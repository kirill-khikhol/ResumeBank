var React = require('react')
var MaskedInput = require('react-text-mask')
var MyComponent = React.createClass({
    render() {
        return (
            <div>
            <MaskedInput mask={['(', /[1-9]/, /\d/, /\d/, ')', ' ', /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]} />
        </div>
    )
    }
})